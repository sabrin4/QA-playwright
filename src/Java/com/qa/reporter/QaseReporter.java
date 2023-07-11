package com.qa.reporter;

import io.qase.api.QaseClient;
import io.qase.api.exceptions.QaseException;
import io.qase.client.ApiClient;
import io.qase.client.api.CasesApi;
import io.qase.client.api.ResultsApi;
import io.qase.client.api.RunsApi;
import io.qase.client.model.ResultCreate;

public class QaseReporter {
    public static ApiClient apiClient;
    public static CasesApi casesApi;
    public static ResultsApi resultsApi;
    public static RunsApi runsApi;

    static {
        apiClient = QaseClient.getApiClient();
        apiClient.setApiKey(System.getenv("QaseApiToken"));
        casesApi = new CasesApi(apiClient);
        resultsApi = new ResultsApi(apiClient);
        runsApi = new RunsApi(apiClient);
    }

    public static void addTestRunResult(String projectCode, int testCaseId) {
        ResultCreate resultCreate = new ResultCreate()
                .caseId((long) testCaseId)
                .status(ResultCreate.StatusEnum.PASSED);
        try {
            String hash = resultsApi.createResult("SP", testCaseId, resultCreate)
                    .getResult().getHash();
        } catch (QaseException e) {
            throw new RuntimeException(e);
        }
    }
}
