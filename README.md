# GRaViTY-SecDFD-Mapping

This repository contains the implementation and evaluation data for our 2019 MODELS paper on Secure Data-Flow Compliance Checks between Models and Code based on Automated Mappings.

## Publication

Our paper will be presented between 18th and 20th September 2019 at [MODELS](http://modelsconference.org) in Munich.

For a precise schedule and more information please refer to the conference website: http://modelsconference.org

### Paper and Preprint

[Sven Peldszus](http://sven.peldszus.com), Katja Tuma, Daniel Strüber, Jan Jürjens, Riccardo Scandariato: *Secure Data-Flow Compliance Checks between Models and Code based on Automated Mappings*. In: Proceedings of the 22nd ACM/IEEE International Conference on Model Driven Engineering Languages and Systems (MODELS), 2019. to appear. 

The preprint is available [here](http://rgse.uni-koblenz.de/web/pages/people/peldszus/publications/PTS+19-MODELS-SecureData-FlowComplianceChecksBetweenModelsAndCodeBasedOnAutomatedMappings.pdf)

### Abstract

During the development of security-critical software, the system implementation must capture the security properties postulated by the architectural design. In our MODELS 2019 paper, we present an approach to support secure data-flow compliance checks between design models and code. To iteratively guide the developer in discovering such compliance violations we introduce automated mappings. These mappings are created by searching for correspondences between a design-level model (Security Data Flow Diagram) and an implementation-level model (Program Model). We limit the search space by considering name similarities between model elements and code elements as well as by the use of heuristic rules for matching data-flow structures. The main contributions of this paper are three-fold. First, the automated mappings support the designer in an early discovery of implementation absence, convergence, and divergence with respect to the planned software design. Second, the mappings also support the discovery of secure data-flow compliance violations in terms of illegal asset flows in the software implementation. Third, we present our implementation of the approach as a publicly available Eclipse plugin and its evaluation on five open source Java projects (including Eclipse secure storage).

## How to use the Tool

A detailed description how to use the tool will be added soon.

A short description is contained in Section IV. - Implementation - of the paper: [preprint](http://rgse.uni-koblenz.de/web/pages/people/peldszus/publications/PTS+19-MODELS-SecureData-FlowComplianceChecksBetweenModelsAndCodeBasedOnAutomatedMappings.pdf)

## Installation

The prototypical implementation of the GRaViTY-SecDFD-Maopping-Tool can be installed into Eclipse from the following updatesite:

https://gravity-tool.org/secdfd-mapper/updatesite/

## Building the Tool

In what follows we describe how the prototypical implementation can be built.

## Structure of this Repository

- `build/` -- The feature project and the updatesite project (The updatesite is hosted [here](https://gravity-tool.org/secdfd-mapper/updatesite/))
- `examples/` -- The examples used for the evaluation
- `implementation/` -- The source code of the prorotypical implementation
- `README.md` -- This readme

### Requirements

To build the tool an Eclipse including the following plugins is required:

- The GRaViTY program model and a transformation engine from: https://gravity-tool.org/updatesite
- Xtext from the Eclipse standard repository: https://download.eclipse.org/modeling/tmf/xtext/updates/composite/releases/

### Build

To built the tool the Eclipse projects from the `implementation/` and the `build` folder of this repository have to be imported into the eclipse workspace. Afterwards the updatesite can be built by opening `org.gravity.mapping.secdfd.updatesite/site.xml` and selecting 'Build All'. Alternatively, the plugins can be installed into the running instance according to the following manal: [Export and Install into the Running Host](https://help.eclipse.org/2019-03/index.jsp?topic=%2Forg.eclipse.pde.doc.user%2Ftasks%2Fui_export_install_into_host.htm)
