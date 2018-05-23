package by.itacademy.company.Company;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;
import java.util.TreeSet;

public class OnlineBaseJSON {
    Set<Company> listOfPatient = new TreeSet<>();
    CompanyBase companyBase;

    public Set<Company> getOnlineBase() {
        try {
            URL url = new URL("https://raw.githubusercontent.com/Zaitsev-95/json_json/master/json.json");
            URLConnection urlConnection = (URLConnection) url.openConnection();
            ObjectMapper mapper = new ObjectMapper();
            SimpleModule sm = new SimpleModule();
            sm.addDeserializer(Company.class, new JacksonCompanyDeserializer());
            mapper.registerModule(sm);
            CompanyBase companyBase = mapper.readValue(url, CompanyBase.class);

            listOfPatient = companyBase.getCompanies();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfPatient;
    }
}