package com.training.micro.service.msnotify;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotifyMessage {
    private String message;
    private String destination;
}
