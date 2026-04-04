package com.debmalya.financial_data_processing.auth.enums;

public enum Permission {

    VIEW_DASHBOARD_SUMMARY,
    VIEW_FINANCIAL_RECORDS,

    CREATE_FINANCIAL_RECORD,
    MODIFY_FINANCIAL_RECORD,     // full edit permission on all financial records
    DELETE_FINANCIAL_RECORD,     // soft delete financial records

    MODIFY_RECORD_NOTES,         // analyst only allowed to edit notes field

    MANAGE_SYSTEM_USERS,
    MANAGE_CATEGORIES
}