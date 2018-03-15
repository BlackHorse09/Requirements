package com.example.sahil.requirement;

import com.google.firebase.database.DatabaseReference;

/**
 * Created by sahil on 11/3/18.
 */

public class RequirementDescription {

    String requirementId;
    String sanstha;
    String spinnerChoice;
    String requirementdescription;



    public RequirementDescription() {

    }

    public RequirementDescription(String requirementId, String sanstha, String spinnerChoice, String requirementdescription) {
        this.requirementId = requirementId;
        this.sanstha = sanstha;
        this.spinnerChoice = spinnerChoice;
        this.requirementdescription = requirementdescription;
    }

    public String getSanstha() {
        return sanstha;
    }

    public String getSpinnerChoice() {
        return spinnerChoice;
    }

    public String getRequirementdescription() {
        return requirementdescription;
    }

    public String getRequirementId() {
        return requirementId;
    }

}
