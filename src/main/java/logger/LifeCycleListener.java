package logger;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LifeCycleListener implements PhaseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager
			.getLogger(LifeCycleListener.class);
	
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

	public void beforePhase(PhaseEvent event) {
		LOGGER.info("INICIANDO FASE: " + event.getPhaseId());
	}

	public void afterPhase(PhaseEvent event) {
		LOGGER.info("FINALIZANDO FASE: " + event.getPhaseId());
	}

}
