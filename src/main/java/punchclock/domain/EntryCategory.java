package punchclock.domain;

public enum EntryCategory {
	
	FIX("FIX"), MONTHLY("MONTHLY"), YEARLY("YEARLY");
	
	public static final EntryCategory[] ALL = { FIX, MONTHLY, YEARLY };

	private final String name;

	private EntryCategory(final String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return getName();
	}

}
