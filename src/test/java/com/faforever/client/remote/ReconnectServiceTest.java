package com.faforever.client.remote;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ReconnectServiceTest {

  private ReconnectService instance;

  @Before
  public void setUp() throws Exception {
    instance = new ReconnectService();
  }

  @Test
  public void testReconnectStaysBelowMax() {
    instance.incrementConnectionFailures();
    instance.incrementConnectionFailures();
    instance.incrementConnectionFailures();
    instance.incrementConnectionFailures();
    instance.incrementConnectionFailures();
    instance.incrementConnectionFailures();
    assertTrue(instance.getReconnectTimeOut() <= ReconnectService.RECONNECT_DELAY_MAX);
  }
}