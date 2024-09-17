package org.example;

public class MaxProjectCountClient {
    private final int clientId;
    private final int projectCount;

    public MaxProjectCountClient(int clientId, int projectCount) {
        this.clientId = clientId;
        this.projectCount = projectCount;
    }

    public int getClientId() {
        return clientId;
    }

    public int getProjectCount() {
        return projectCount;
    }

    @Override
    public String toString() {
        return "MaxProjectCountClient{" +
                "clientId=" + clientId +
                ", projectCount=" + projectCount +
                '}';
    }
}
