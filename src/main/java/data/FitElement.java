package data;

/**
 * Created by once2go on 19/01/17.
 */
public class FitElement {

    private String link;
    private boolean alreadyAdded;
    private String title;

    public FitElement(String link) {
        this.link = link;
    }


    public int getAddid() {
        int queryIndex = link.lastIndexOf('?');
        return Integer.parseInt(link.substring(link.lastIndexOf('/') + 1,
                queryIndex == -1 ? link.length() : queryIndex));
    }

    public String getLink() {
        return link;
    }

    public boolean isAlreadyAdded() {
        return alreadyAdded;
    }

    public void setAlreadyAdded(boolean alreadyAdded) {
        this.alreadyAdded = alreadyAdded;
    }

    @Override
    public String toString() {
        return "FitElement{" +
                "link='" + link + '\'' +
                "id='" + getAddid() + '\'' +
                ", alreadyAdded=" + alreadyAdded +
                '}';
    }
}
