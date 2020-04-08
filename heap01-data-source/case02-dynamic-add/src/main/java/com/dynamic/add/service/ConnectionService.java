package com.dynamic.add.service;

import com.dynamic.add.entity.ConnectionEntity;

public interface ConnectionService {

    boolean testConnection (ConnectionEntity connectionEntity) ;

    boolean addConnection (ConnectionEntity connectionEntity) ;
}
