package org.gravity.mapping.secdfd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.gravity.eclipse.io.ExtensionFileVisitor;
import org.gravity.eclipse.util.EclipseProjectUtil;
import org.gravity.mapping.secdfd.checks.impl.FwdJoinCheck;
import org.gravity.mapping.secdfd.mapping.Mapper;
import org.junit.BeforeClass;
import org.junit.Test;
import org.secdfd.dsl.validation.SResult;
import org.secdfd.dsl.validation.SResult.PState;
import org.secdfd.model.Asset;
import org.secdfd.model.Element;
import org.secdfd.model.ModelFactory;
import org.secdfd.model.Process;
import org.secdfd.model.Responsibility;
import org.secdfd.model.ResponsibilityType;

public class FwdTest {

	private static Map<String, IProject> projects;

	@BeforeClass
	public static void initialize() throws CoreException {
		projects = EclipseProjectUtil.importProjects(new File("instances"), new NullProgressMonitor()).parallelStream()
				.collect(Collectors.toMap(IProject::getName, project -> project));
	}

	/**
	 * @throws CoreException
	 * @throws IOException
	 *
	 */
	@Test
	public void fwdCorrect() throws IOException, CoreException {
		final Mapper mapper = initMapper("ForwardExample");
		final Process processMain = getProcess("main", mapper);

		// Perform the test
		final SResult status = new FwdJoinCheck().check(processMain, mapper);
		assertEquals(PState.SUCCESS, status.getState());
	}

	/**
	 * @throws CoreException
	 * @throws IOException
	 *
	 */
	@Test
	public void joinCorrect() throws IOException, CoreException {
		final Mapper mapper = initMapper("JoinExample");
		final Process processMain = getProcess("join", mapper);

		// Perform the test
		final SResult status = new FwdJoinCheck().check(processMain, mapper);
		assertEquals(PState.SUCCESS, status.getState());
	}

	/**
	 * @throws CoreException
	 * @throws IOException
	 *
	 */
	@Test
	public void joinIsFwd() throws IOException, CoreException {
		final Mapper mapper = initMapper("ForwardExample");
		final Process processMain = getProcess("main", mapper);
		final Responsibility fwd = processMain.getResponsibility().get(0);

		final Asset asset = ModelFactory.eINSTANCE.createAsset();
		asset.setName("InjectedAsset");
		fwd.getIncomeassets().add(asset);

		final EList<ResponsibilityType> actions = fwd.getAction();
		actions.clear();
		actions.add(ResponsibilityType.JOINER);

		// Perform the test
		final SResult status = new FwdJoinCheck().check(processMain, mapper);
		assertEquals(PState.ERROR, status.getState());
	}

	/**
	 * @throws CoreException
	 * @throws IOException
	 *
	 */
	@Test
	public void fwdIsJoin() throws IOException, CoreException {
		final Mapper mapper = initMapper("JoinExample");
		final Process processMain = getProcess("join", mapper);
		final Responsibility fwd = processMain.getResponsibility().get(0);

		fwd.getIncomeassets().remove(0);

		final EList<ResponsibilityType> actions = fwd.getAction();
		actions.clear();
		actions.add(ResponsibilityType.FORWARD);

		// Perform the test
		final SResult status = new FwdJoinCheck().check(processMain, mapper);
		assertEquals(PState.ERROR, status.getState());
	}


	/**
	 * Searches for a process with the given name
	 *
	 * @param processName
	 * @param mapper
	 * @return
	 */
	private Process getProcess(final String processName, final Mapper mapper) {
		final Optional<Element> result = mapper.getDFD().getElements().parallelStream()
				.filter(p -> processName.equals(p.getName())).findAny();
		assertTrue(result.isPresent());
		return (Process) result.get();
	}

	/**
	 * Initializes a mapper for the project with the given name
	 *
	 * @param name The project name
	 * @return The mapper
	 * @throws IOException
	 * @throws CoreException
	 */
	private Mapper initMapper(final String name) throws IOException, CoreException {
		assertTrue(projects.containsKey(name));
		final IProject project = projects.get(name);
		final IFolder gravity = EclipseProjectUtil.getGravityFolder(project, new NullProgressMonitor());
		final ExtensionFileVisitor visitor = new ExtensionFileVisitor(".corr.xmi");
		gravity.accept(visitor);
		final List<Path> files = visitor.getFiles();
		assertEquals(1, files.size());
		final Mapper mapper = new Mapper(gravity.getFile(files.get(0).getFileName().toString()));
		return mapper;
	}

}
