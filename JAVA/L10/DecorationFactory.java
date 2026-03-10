public class DecorationFactory {
    public static IDecoration getDecoration(String decorationName) throws UnknownDecrationException{
        String normalized = decorationName.toUpperCase().trim();

        try {
            DecorationType type = DecorationType.valueOf(normalized);
            switch (type) {
                case BAUBLES -> {
                    return new BaublesDecoration();
                }
                case ANGEL -> {
                    return new AngelDecoration();
                }
                case LIGHTS -> {
                    return new LightsDecoration();
                }
                default -> {
                    throw new UnknownDecrationException("No implementation for: " + decorationName);
                }
            }
        } catch (IllegalArgumentException e) {
            throw new UnknownDecrationException("Unknown decoration type: " + decorationName);
        }
    }
}
