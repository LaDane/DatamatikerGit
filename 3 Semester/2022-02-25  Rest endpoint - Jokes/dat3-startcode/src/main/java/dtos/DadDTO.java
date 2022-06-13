package dtos;

public class DadDTO {
    String id;
    String joke;
    String status;

    public DadDTO() {}

    public DadDTO(String id, String joke, String status) {
        this.id = id;
        this.joke = joke;
        this.status = status;
    }

    @Override
    public String toString() {
        return "DadDTO{" +
                "id='" + id + '\'' +
                ", joke='" + joke + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
