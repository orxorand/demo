package com.example.demo.service;

import com.example.demo.model.MessageTranslation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Locale;

@Named
public class StatusService {

  private SessionFactory sessionFactory;

  @Inject
  public StatusService(
      SessionFactory sessionFactory
  ) {
    this.sessionFactory = sessionFactory;
  }

  @Transactional(readOnly = true)
  public String status() {
    Session session = sessionFactory.getCurrentSession();
    MessageTranslation result = session.createQuery(
            """
            SELECT myMsgTr
            FROM MessageTranslation myMsgTr
            WHERE myMsgTr.code = :myParamName and myMsgTr.region = :region
            """,
            MessageTranslation.class)
        .setParameter("myParamName", "app.status.normal")
        .setParameter("region", Locale.getDefault().getCountry())
        .getSingleResult();
    return result.getValue();
  }
}
