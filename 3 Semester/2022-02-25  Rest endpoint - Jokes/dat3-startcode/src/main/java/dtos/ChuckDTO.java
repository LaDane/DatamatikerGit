package dtos;

public class ChuckDTO {
    String created_at;
    String icon_url;
    String id;
    String updated_at;
    String url;
    String value;

    public ChuckDTO() {}

    public ChuckDTO(String created_at, String icon_url, String id, String updated_at, String url, String value) {
        this.created_at = created_at;
        this.icon_url = icon_url;
        this.id = id;
        this.updated_at = updated_at;
        this.url = url;
        this.value = value;
    }

    @Override
    public String toString() {
        return "ChuckDTO{" +
                "created_at='" + created_at + '\'' +
                ", icon_url='" + icon_url + '\'' +
                ", id='" + id + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", url='" + url + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
