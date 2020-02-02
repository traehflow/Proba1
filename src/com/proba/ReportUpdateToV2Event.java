package com.proba;

import java.util.Objects;
import java.util.UUID;

public class ReportUpdateToV2Event {
    private UUID reportUUID;
    private Long completedAt;

    public ReportUpdateToV2Event reportUUID(UUID reportUUID){
        this.reportUUID = reportUUID;
        return this;
    }

    public ReportUpdateToV2Event completedAt(Long completedAt){
        this.completedAt = completedAt;
        return this;
    }

    public UUID getReportUUID() {
        return reportUUID;
    }

    public void setReportUUID(UUID reportUUID) {
        this.reportUUID = reportUUID;
    }

    public Long getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Long completedAt) {
        this.completedAt = completedAt;
    }

    @Override
    public String toString() {
        return "ReportUpdateToV2Event{" +
                "reportUUID=" + reportUUID +
                ", completedAt=" + completedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReportUpdateToV2Event)) return false;
        ReportUpdateToV2Event that = (ReportUpdateToV2Event) o;
        return Objects.equals(reportUUID, that.reportUUID) &&
                Objects.equals(completedAt, that.completedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportUUID, completedAt);
    }

    public static void main (String[] argv){
        ReportUpdateToV2Event a = new ReportUpdateToV2Event().reportUUID(UUID.fromString("433443-45455-544-23344-5445")).completedAt((long) 4334);
        System.out.println(a);
    }
}