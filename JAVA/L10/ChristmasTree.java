import java.util.ArrayList;
import java.util.List;

public abstract class ChristmasTree {
    protected List<StringBuilder> treeLines;
    protected int height;

    public ChristmasTree(int height) {
        if (height < 2) {
            throw new IllegalArgumentException("Height must be at least 2");
        }
        this.height = height;
        this.treeLines = new ArrayList<>();
    }

    public abstract void generateTree();

    public void applyDecoration(IDecoration decoration){
        if (treeLines.isEmpty()){
            generateTree();
        }
        decoration.decorate(this.treeLines);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (StringBuilder line : treeLines) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }
}
