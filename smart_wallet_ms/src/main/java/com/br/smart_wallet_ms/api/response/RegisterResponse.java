package com.br.smart_wallet_ms.api.response;

import java.util.Date;

public record RegisterResponse(Date initialDate, Date finalDate, String category) {
}
