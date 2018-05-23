package by.itacademy.company.Company;

import by.itacademy.company.Exception.CompanyBuilderException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JacksonCompanyDeserializer extends StdDeserializer<Company> {

    public JacksonCompanyDeserializer() {
        this(null);
    }

    public JacksonCompanyDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Company deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        String name = node.get("name").asText();
        String dateOfCreation = node.get("dateOfCreation").asText();
        List<String> strings=new ArrayList<>();
        JsonNode arrNode = new ObjectMapper().readTree(String.valueOf(node)).get("specialization");
        if (arrNode.isArray()) {
            for (final JsonNode objNode : arrNode) {
                strings.add(String.valueOf(objNode));
            }
        }
        String personal = node.get("personal").asText();
        String isForeign = node.get("isForeign").asText();
        try {
            return Company.CompanyBuilder.createCompanyBuilder()
                    .setName(name)
                    .setDateOfCreation(dateOfCreation)
                    .setSpecialization(strings )
                    .setPersonal(personal)
                    .setIsForeign(isForeign)
                    .getCompany();
        } catch (CompanyBuilderException e) {
            return null;
        }
    }
}