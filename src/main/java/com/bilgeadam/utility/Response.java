package com.bilgeadam.utility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response <T>{

    /**
     * 200 -> Başarılı
     * 400 -> Başarısız - Kullanıcı kaynaklı hata
     * 500 -> Başarısız - Program kaynaklı hata
     */
    int statusCode;
    /**
     * Başarılı ise olumlu mesajlar
     * Başarısız ise nedeni açıklamalı olarak belirtilen mesajlar
     */
    String message;
    /**
     * Eğer başarılı bir şekilde sonlanmış ise kullanıcıya iletilecek bilgi datası
     */
    T data;
}
