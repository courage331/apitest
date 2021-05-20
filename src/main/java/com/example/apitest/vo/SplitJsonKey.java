package com.example.apitest.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SplitJsonKey {
    private String key;
    private LocalDateTime expiryDate;

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof SplitJsonKey)) return false;

        SplitJsonKey other = (SplitJsonKey) obj;
        return key.equals(other.getKey());
    }

    @Builder
    public SplitJsonKey(String key) {
        this.key = key;
        this.expiryDate = LocalDateTime.now().plusHours(1);
    }

}
