package com.jaime.practices.practices1.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
//Scope("singleton") //Every time you inject or request this bean, you get the same object. It's the default
@Scope("prototype") //A new instance in created every time the bean is requested
public class ExampleScopesService {

}
