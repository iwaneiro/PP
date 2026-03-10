public class PineTree extends ChristmasTree{
    public PineTree(int height) {
        super(height);
        generateTree();
    }

    @Override
    public void generateTree() {
        treeLines.clear();
        for (int row = 0; row < height; row++) {
            StringBuilder line = new StringBuilder();

            for (int s = 0; s < height - row - 1; s++) {
                line.append(" ");
            }

            for (int stars = 0; stars < (2*row+1); stars++) {
                line.append("*");
            }
            treeLines.add(line);
        }
    }
}
