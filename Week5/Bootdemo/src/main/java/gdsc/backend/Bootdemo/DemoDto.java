package gdsc.backend.Bootdemo;

import lombok.Getter;

@Getter
public class DemoDto {
    @Getter
    private Long id;
    private String name;

    public DemoDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
