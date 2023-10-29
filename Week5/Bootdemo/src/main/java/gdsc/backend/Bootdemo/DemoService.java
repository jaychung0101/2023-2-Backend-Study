package gdsc.backend.Bootdemo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DemoService {
    private final List<DemoEntity> demoEntities = new ArrayList<>(Arrays.asList(
            new DemoEntity(1L, "1번"),
            new DemoEntity(2L, "2번"),
            new DemoEntity(3L, "3번")
    ));

    public List<DemoDto> getDemoEntities() {
        List<DemoDto> demoDtos = new ArrayList<>();
        for (DemoEntity demoEntity : demoEntities) {
            demoDtos.add(new DemoDto(demoEntity.getId(), demoEntity.getName()));
        }
        return demoDtos;
    }

    public void addDemoEntity(DemoDto demoDto) {
        demoEntities.add(new DemoEntity(demoDto.getId(), demoDto.getName()));
    }

    public DemoDto getDemoEntityName(Long id) {
        List<DemoDto> demoDtos = new ArrayList<>();
        for (DemoEntity demoEntity : demoEntities) {
            demoDtos.add(new DemoDto(demoEntity.getId(), demoEntity.getName()));
        }

        for (DemoDto dto : demoDtos) {
            if (dto.getId().equals(id)) {
                return new DemoDto(id, dto.getName());
            }
        }
        return null;
    }
}