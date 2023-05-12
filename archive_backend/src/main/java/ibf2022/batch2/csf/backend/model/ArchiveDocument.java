package ibf2022.batch2.csf.backend.model;

import java.time.LocalDateTime;
import java.util.List;

public class ArchiveDocument {
    private String bundledId;
    private LocalDateTime date;
    private String title;
    private String name;
    private String comments;
    private List<String> urls;

    public ArchiveDocument(){

    }

    public ArchiveDocument(String bundledId, LocalDateTime date, String title, String name, String comments,
            List<String> urls) {
        this.bundledId = bundledId;
        this.date = date;
        this.title = title;
        this.name = name;
        this.comments = comments;
        this.urls = urls;
    }
    public String getBundledId() {
        return bundledId;
    }
    public void setBundledId(String bundledId) {
        this.bundledId = bundledId;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public List<String> getUrls() {
        return urls;
    }
    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "ArchiveDocument [bundledId=" + bundledId + ", date=" + date + ", title=" + title + ", name=" + name
                + ", comments=" + comments + ", urls=" + urls + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bundledId == null) ? 0 : bundledId.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((comments == null) ? 0 : comments.hashCode());
        result = prime * result + ((urls == null) ? 0 : urls.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ArchiveDocument other = (ArchiveDocument) obj;
        if (bundledId == null) {
            if (other.bundledId != null)
                return false;
        } else if (!bundledId.equals(other.bundledId))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (comments == null) {
            if (other.comments != null)
                return false;
        } else if (!comments.equals(other.comments))
            return false;
        if (urls == null) {
            if (other.urls != null)
                return false;
        } else if (!urls.equals(other.urls))
            return false;
        return true;
    }
    
    
}
