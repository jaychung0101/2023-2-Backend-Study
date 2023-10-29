package gdsc.backend.Bootdemo;

import lombok.Getter;

@Getter
public class DemoEntity {
    private Long id;
    private String name;

    public DemoEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
