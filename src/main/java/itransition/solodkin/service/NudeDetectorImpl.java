package itransition.solodkin.service;

import com.algorithmia.APIException;
import com.algorithmia.AlgorithmException;
import com.algorithmia.Algorithmia;
import com.algorithmia.AlgorithmiaClient;
import com.algorithmia.algo.AlgoResponse;
import com.algorithmia.algo.Algorithm;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class NudeDetectorImpl implements NudeDetector {

    private final AlgorithmiaClient algorithmiaClient = Algorithmia.client("simNqwyTg2GWybzFgPBFM+uju9D1");
    private final Algorithm algorithm = algorithmiaClient.algo("algo://sfw/NudityDetectioni2v/0.2.11");

    @Override
    public boolean check(String url) {
        try {
            AlgoResponse response = algorithm.pipeJson("\"" + url + "\"");
            JSONObject jsonResponse = (JSONObject) new JSONParser().parse(response.asJsonString());
            if (Boolean.parseBoolean(jsonResponse.get("nude").toString())) {
                return false;
            }
            return true;
        } catch (APIException e) {
            e.printStackTrace();
        } catch (AlgorithmException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
