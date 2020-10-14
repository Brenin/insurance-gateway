package com.insurance.gateway.dto.operations;

import javafx.util.Pair;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NonNull
public class CancelContractResponse extends AbstractResponse {

    @NonNull private boolean customerWasCancelled;
             private boolean contractWasCancelled;

    public CancelContractResponse(String errorMessage, @NonNull Pair<Boolean, Boolean> rollbackFlags) {
        super(errorMessage);
        this.customerWasCancelled = rollbackFlags.getKey();
        this.contractWasCancelled = rollbackFlags.getValue();
    }
}
