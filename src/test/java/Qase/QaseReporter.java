package Qase;

import io.qase.api.QaseClient;
import io.qase.api.exceptions.QaseException;
import io.qase.client.ApiClient;
import io.qase.client.api.CasesApi;
import io.qase.client.api.ResultsApi;
import io.qase.client.model.ResultCreate;

public class QaseReporter {
    static ApiClient apiClient;
    static CasesApi casesApi;
    static ResultsApi resultsApi;

    static {
        apiClient = QaseClient.getApiClient();
        apiClient.setApiKey(System.getenv("QaseApiToken"));
        casesApi = new CasesApi(apiClient);
        resultsApi = new ResultsApi(apiClient);
    }

    public static void main(String[] args) {
        addTestRunResult("SP", 10);
    }

    public static void addTestRunResult(String projectCode, int testCaseId) {
        ResultCreate resultCreate = new ResultCreate()
                .caseId(10L)
                .status(ResultCreate.StatusEnum.PASSED);
        try {
            String hash = resultsApi.createResult(projectCode, testCaseId, resultCreate)
                    .getResult().getHash();
        } catch (QaseException e) {
            throw new RuntimeException(e);
        }
    }
}
