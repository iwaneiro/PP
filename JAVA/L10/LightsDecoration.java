import java.util.List;

public class LightsDecoration implements  IDecoration{
    @Override
    public void decorate(List<StringBuilder> treeRepresenation) {
        for (StringBuilder line : treeRepresenation) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '*' && i%2 == 1) {
                    line.setCharAt(i, 'x');
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Lights (lampki)";
    }
}
