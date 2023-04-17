package com.ada.aulajunit;

import com.ada.aulajunit.modelo.DollarQuotation;
import com.ada.aulajunit.service.BancoCentralAPI;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import javax.json.JsonArray;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

public class DollarQuotationTest {

    private static final String YEAR_MONTH_PATTERN = "MM-yyyy";
    private static final String DATE_TIME_PATTERN = "dd/MM/yyyy HH:mm";
    @ParameterizedTest
    @MethodSource("variableQuotationParams")
    public void test(int billingDay, String invoiceYearMonth, String expectedQuotationDate, String expectedQuotationValue) throws UnirestException, JSONException, ParseException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YEAR_MONTH_PATTERN);
        YearMonth yearMonth = YearMonth.parse(invoiceYearMonth, formatter);

        DollarQuotation quotation = new BancoCentralAPI().findDollarQuotation("04-05-2023");

        formatter = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
        LocalDateTime dateTime = LocalDateTime.parse(expectedQuotationDate, formatter);
        Date expectedDate = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        Assertions.assertEquals(expectedDate, quotation.getDate());
        Assertions.assertEquals(new BigDecimal(expectedQuotationValue), quotation.getSaleQuotation());
    }

    /**
     * Constrói os dados que serão usados nos casos de teste de cotação.
     * @return Parâmetros para os casos de teste da cotação
     */
    public static Collection<?> variableQuotationParams() {
        return Arrays.asList(new Object[][] {
                /* 	billingDay		invoiceYearMonth		expectedQuotationDate		expectedQuotationValue */
                {		20, 			"02-2020",			"20/02/2020 00:00",					"4.3873"}, // Véspera de Carnaval
                {		21, 			"02-2020",			"21/02/2020 00:00",					"4.3924"}, // Carnaval
                {		22, 			"02-2020",			"21/02/2020 00:00",					"4.3924"}, // Carnaval
                {		23, 			"02-2020",			"21/02/2020 00:00",					"4.3924"}, // Carnaval
                {		24, 			"02-2020",			"21/02/2020 00:00",					"4.3924"}, // Carnaval
                {		25, 			"02-2020",			"21/02/2020 00:00",					"4.3924"}, // Carnaval
                {		26, 			"02-2020",			"26/02/2020 00:00",					"4.4359"}, // Cinzas
                {		27, 			"02-2020",			"27/02/2020 00:00",					"4.4764"}, // Pós-Carnaval
                {		10, 			"04-2020",			"09/04/2020 00:00",					"5.0779"}, // Sexta-feira Santa
                {		21, 			"04-2020",			"20/04/2020 00:00",					"5.2837"}, // Tiradentes
                {		01, 			"05-2020",			"30/04/2020 00:00",					"5.4270"}, // Dia do Trabalho (sexta)

                {		07, 			"09-2020",			"04/09/2020 00:00",					"5.2848"}, // Independência do Brasil (segunda)
                {		12, 			"10-2020",			"09/10/2020 00:00",					"5.5393"}, // Nossa Sra Aparecida (segunda)
                {		 2, 			"11-2020",			"30/10/2020 00:00",					"5.7718"}, // Finados (segunda)
                {		15, 			"11-2020",			"13/11/2020 00:00",					"5.4854"}, // Proclamação da República (domingo)
                {		25, 			"12-2020",			"24/12/2020 00:00",					"5.1800"}, // Natal
                {		31, 			"12-2020",			"31/12/2020 00:00",					"5.1967"}, // Reveillon

                {		 1, 			"01-2021",			"31/12/2020 00:00",					"5.1967"}, // Ano novo
                {		 2, 			"01-2021",			"31/12/2020 00:00",					"5.1967"},
                {		 3, 			"01-2021",			"31/12/2020 00:00",					"5.1967"},
                {		 4, 			"01-2021",			"04/01/2021 00:00",					"5.1626"},
                {		 5, 			"01-2021",			"05/01/2021 00:00",					"5.3269"},
                {		 6, 			"01-2021",			"06/01/2021 00:00",					"5.3182"},
                {		 7, 			"01-2021",			"07/01/2021 00:00",					"5.3433"},
                {		 8, 			"01-2021",			"08/01/2021 00:00",					"5.3683"},
                {		 9, 			"01-2021",			"08/01/2021 00:00",					"5.3683"},
                {		10, 			"01-2021",			"08/01/2021 00:00",					"5.3683"},

                {		11, 			"01-2021",			"11/01/2021 00:00",					"5.4966"},
                {		12, 			"01-2021",			"12/01/2021 00:00",					"5.4637"},

        });
    }

}
