package jp.co.axa.apidemo.components;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

// Component for ModelMapper
// ModelMapper is used for Entity <-> DTO mapping
@Component
public class ModelMapperComponent {

    @Getter
    private ModelMapper mapper = new ModelMapper();

    // Default constructor, we use Strict MappingStrategy for our ModelMapper
    public ModelMapperComponent() {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

}
