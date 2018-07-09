package Conversion;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import Model.CurrencyConversionResponse;

import Model.Expenses;
import com.google.gson.Gson;

public class CurrencyConvertor {

    private static final String API_PROVDIER = "http://data.fixer.io/api/latest?access_key=822d52cc9e2a7cb687fe64925775e220&base=";

    public static double convert(String toCurrencyCode, String fromCurrencyCode) {

        if ((fromCurrencyCode != null && !fromCurrencyCode.isEmpty())
                && (toCurrencyCode != null && !toCurrencyCode.isEmpty())) {

            CurrencyConversionResponse response = getResponse(API_PROVDIER+fromCurrencyCode+"&symbols"+toCurrencyCode);

            if(response != null) {

                String rate = response.getRates().get(toCurrencyCode);

                double conversionRate = Double.valueOf((rate != null)?rate:"0.0");

                return conversionRate;
            }
        }
        return 0.0;
    }


    private static CurrencyConversionResponse getResponse(String strUrl) {

        CurrencyConversionResponse response = null;

        Gson gson = new Gson();
        StringBuffer sb = new StringBuffer();

        if (strUrl == null || strUrl.isEmpty()) {

            System.out.println("Error");
            return null;
        }

        URL url;
        try {
            url = new URL(strUrl);

            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();

            InputStream stream = connection.getInputStream();

            int data = stream.read();

            while (data != -1) {

                sb.append((char) data);

                data = stream.read();
            }

            stream.close();

            response = gson.fromJson(sb.toString(), CurrencyConversionResponse.class);

        } catch (MalformedURLException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        } catch (IOException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return response;
    }
}


