package jif.lang;

import java.security.Principal;

/**
 * TODO Documentation
 */
public abstract class AbstractPrincipal implements Principal {
	private final String name;
	protected Principal[] superiors = null;

	protected AbstractPrincipal(String name) {
		this.name = name;
	}

	public String name() {
		return name;
	}

	public boolean delegatesTo(Principal p) {
		return superiorsContains((Principal) p);
	}

	public void addDelegatesTo(Principal p) {
		if (superiorsContains((Principal) p)) {
			return;
		}
		// need to add p to the superiors.
		try {
			if (superiors == null) {
				superiors = new Principal[1];
				superiors[0] = (Principal) p;
			} else {
				Principal[] old = superiors;
				superiors = new Principal[old.length + 1];
				for (int i = 0; i < old.length; i++) {
					superiors[i] = old[i];
				}
				superiors[old.length] = (Principal) p;
			}
		} catch (NullPointerException impossible) {
		} catch (ArrayStoreException impossible) {
		} catch (ArrayIndexOutOfBoundsException impossible) {
		}
	}

	protected boolean superiorsContains(Principal p) {
        boolean result = false;
        Principal[] sprs = superiors;
        for (int i = 0; sprs != null && i < sprs.length; i++) {
            try {
                Principal pi = sprs[i];                        
                if (p == pi || (pi != null && pi.equals(p))) {
                    result = true;
                    break;
                }
            }
            catch (ArrayIndexOutOfBoundsException impossible) {}
        }
        return (result);
    }

	public boolean isAuthorized(Object authPrf, Closure closure) {
		// The default is that this principal authorizes no closures.
		return false;
	}

	public Principal[] findChainDownto(Principal q) {
		// don't even try! We don't have any information
		// about who we can act for.
		return null;
	}

	public Principal[] findChainUpto(Principal p) {
		int d = 0;
		// go through our set of superiors, and see if we can find a chain
		// from them to p.
		Principal[] chain;

		Principal[] sprs = (superiors);

		for (int i = 0; sprs != null && i < sprs.length; i++) {
			try {
				Principal s = (sprs[i]);
				Principal[] exclude = addToChainBottom(null, this, d);
				chain = PrincipalUtil.findDelegatesChain(p, s, exclude);
				if (chain != null) {
					// success!
					// create a longer chain with this at the bottom
					return addToChainBottom(chain, this, d);
				}
			} catch (ArrayIndexOutOfBoundsException impossible) {
			}
		}

		return null;
	}

	private boolean inExclude(Principal s, Principal[] exclude, int dummy) {
		try {
			for (int j = 0; exclude != null && j < exclude.length; j++) {
				Principal q = exclude[j];
				if (s == q)
					return true; // also test equals()-equality?
			}
		} catch (ArrayIndexOutOfBoundsException impossible) {
		}
		return false;
	}

	public Principal[] findChainUpto(Principal p, Principal[] exclude) {
		int d = 0;
		// go through our set of superiors, and see if we can find a chain
		// from them to p.
		Principal[] chain;

		// exclude anything we've seen before
		Principal[] newExclude = addToChainBottom(exclude, this, d);

		Principal[] sprs = (superiors);

		for (int i = 0; sprs != null && i < sprs.length; i++) {
			try {
				Principal s = sprs[i];

				boolean cycle = inExclude(s, exclude, d);
				if (!cycle) {
					chain = PrincipalUtil.findDelegatesChain(p, s, newExclude);
					if (chain != null) {
						// success!
						// create a longer chain with this at the bottom
						return addToChainBottom(chain, this, d);
					}
				}
			} catch (ArrayIndexOutOfBoundsException impossible) {
			}
		}

		return null;
	}

	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o instanceof Principal) {
			return equals((Principal) o);
		}
		return false;
	}

	public boolean equals(Principal p) {
		if (p == null)
			return false;
		return (this.name == p.getName() || (this.name != null && this.name.equals(p.getName())))
				&& this.getClass() == p.getClass();
	}

	/**
	 * Create a new chain of length <code>chain.length+1</code>, such that the last
	 * element of the new chain is <code>p</code>, and all other elements are copied
	 * over from <code>chain</code>.
	 */
	static protected Principal[] addToChainBottom(Principal[] chain, Principal p, int dummy) {
		if (chain == null) {
			Principal[] newChain = new Principal[1];
			try {
				newChain[0] = p;
			} catch (ArrayStoreException impossible) {
			} catch (ArrayIndexOutOfBoundsException impossible) {
			}

			return newChain;
		}

		Principal[] newChain = new Principal[chain.length + 1];
		try {
			for (int i = 0; i < chain.length; i++) {
				newChain[i] = chain[i];
			}
			newChain[chain.length] = p;
		} catch (ArrayStoreException impossible) {
		} catch (ArrayIndexOutOfBoundsException impossible) {
		}

		return newChain;
	}

	/**
	 * Create a new chain of length <code>chain.length+1</code>, such that the first
	 * element of the new chain is <code>p</code>, and all other elements are copied
	 * over from <code>chain</code>, offset by one.
	 */
	static protected Principal[] addToChainTop(Principal p, Principal[] chain, int dummy) {
		if (chain == null) {
			Principal[] newChain = new Principal[1];
			try {
				newChain[0] = p;
			} catch (ArrayStoreException impossible) {
			} catch (ArrayIndexOutOfBoundsException impossible) {
			}

			return newChain;
		}

		Principal[] newChain = new Principal[chain.length + 1];
		try {
			newChain[0] = p;
			for (int i = 0; i < chain.length; i++) {
				newChain[i + 1] = chain[i];
			}
		} catch (ArrayStoreException impossible) {
		} catch (ArrayIndexOutOfBoundsException impossible) {
		}

		return newChain;
	}
}
