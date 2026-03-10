import java.util.List;

public class AngelDecoration implements IDecoration{
    @Override
    public void decorate(List<StringBuilder> treeRepresenation) {
        if (!treeRepresenation.isEmpty()) {
            StringBuilder topRow = treeRepresenation.getFirst();
            int centerIndex = topRow.indexOf("*");
            if (centerIndex != -1) {
                topRow.setCharAt(centerIndex, 'A');
            }
        }
    }

    @Override
    public String toString() {
        return "Angel (aniołek)";
    }
}
