/*
    Group 2 CPCS324 Poject 
*/
package GraphFrameWrok;

public class Subset {
    int parent, rank;

    // subsets differ from the "parent" attribute in edge class is that in here you can combine subsets together while
    // you can't combine edges together. 
    // rank determines which subset has a higher height (imagine it like a tree)
    public Subset(int parent, int rank)
    {
        this.parent = parent;
        this.rank = rank;
    }
}