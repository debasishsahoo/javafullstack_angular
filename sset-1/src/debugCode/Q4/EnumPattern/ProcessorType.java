package debugCode.Q4.EnumPattern;

public enum ProcessorType {
	FAST {
        @Override
        public void process() {
            System.out.println("Fast enum processing");
        }
    },
    SAFE {
        @Override
        public void process() {
            System.out.println("Safe enum processing");
        }
    };

    public abstract void process();

    // Class-level operation with polymorphic behavior
    public static ProcessorType getDefault() {
        return FAST;
    }
}
