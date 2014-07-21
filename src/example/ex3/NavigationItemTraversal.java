package example.ex3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: usha
 * Date: 10/11/12
 * Time: 8:17 PM
 */
class NavigationItem {
    public String url;
    public String label;
    public List<NavigationItem> children;

    public String getUrl() {
        return url;
    }

    public String getLabel() {
        return label;
    }

    public List<NavigationItem> getChildren() {
        return children;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setChildren(List<NavigationItem> children) {
        this.children = children;
    }
}

public class NavigationItemTraversal {

    public static void printNavigationItems(NavigationItem item) {

        System.out.println(item.getLabel() + " : " + item.getUrl());
        if (item.getChildren() == null || item.getChildren().isEmpty()) {
            return;
        }
        int depth = 1;
        for (NavigationItem child : item.getChildren()) {
            printDepth(depth, child);
//            printNavigationItems(child);
            depth++;
        }

    }

    private static void printDepth(int depth, NavigationItem item) {
        System.out.println(item.getLabel() + " : " + item.getUrl());
        if (item.getChildren() == null || item.getChildren().isEmpty()) {
            return;
        }
        for (int i = 1; i <= depth; i++) {
            System.out.print("  ");

            for (NavigationItem level : item.getChildren()) {
                System.out.println(level.getLabel() + " : " + level.getUrl());
                printDepth(i, level);
            }
        }
    }

    public static void main(String[] args) {

        NavigationItem root = new NavigationItem();
        root.setLabel("a");
        root.setUrl("aurl");

        NavigationItem child1 = new NavigationItem();
        child1.setLabel("b");
        child1.setUrl("burl");

        NavigationItem child2 = new NavigationItem();
        child2.setLabel("c");
        child2.setUrl("curl");

        NavigationItem child3 = new NavigationItem();
        child3.setLabel("d");
        child3.setUrl("durl");

        List<NavigationItem> children3 = new ArrayList<NavigationItem>();
        children3.add(child3);

        child2.setChildren(children3);

        List<NavigationItem> children = new ArrayList<NavigationItem>();
        children.add(child1);
        children.add(child2);

        root.setChildren(children);
        NavigationItemTraversal.printNavigationItems(root);
    }

}
