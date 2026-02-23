package com.team6.EpicEnergyService.payloads;

import java.util.List;

public record ErrorsListDTO (String message, List<String> errors) {
}
