package treeStructure;

// pagina tem tamanho fixo?
// tem um ponteiro para a pagina a direita
public class BTreePage {
    public BTreeNode nodesStructure;
    public BTreePage rightBranch;
    public int n; // num nós

    public BTreePage(){
        this.nodesStructure = null;
        this.rightBranch = null;
        this.n = 0;
    }
}
