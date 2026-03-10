import java.util.List;

public class BaublesDecoration implements IDecoration{
    @Override
    public void decorate(List<StringBuilder> treeRepresenation) {
        for (StringBuilder line : treeRepresenation) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '*' && i%2 == 0) {
                    line.setCharAt(i, 'o');
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Baubles (bombki)";
    }
}
