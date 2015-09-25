TESTE:property-monitor
================

Property-monitor é uma ferramenta que tem como objetivo facilitar o processo de monitoramento de fields de uma objecto, seja ele uma entidade, pojo, controller etc.

Quando a mesma é aplicada sobre um objeto java torna-se possivel questionar ao objecto sobre possiveis mudanças de estado dos seus fields. Trocas de valores são logadas para melhorar a visualição de operações sobre os objetos monitorados.

A ferramenta pode ser aplicada sobre qualquer plataforma java.


Exemplos de utilização:

1º Declare o monitor como atributo de sua classe

----------------------------------------------------

/* Utiliza-se @Transiente levando em conta que o 
exemplo é sobre uma entidade. */

	@Transient
	public PropertyMonitor propertyMonitor = new PropertyMonitor(this);

	private User user;

----------------------------------------------------

2º Aplique o monitoramento sobre a logica que achar conveniente. Nesse caso o momento
a ser monitorado é o set de valores.

	public void setUser(User user) {
		User oldValue = this.user;
		this.user = user;

		propertyMonitor.getPropertyChangeSupport().firePropertyChange("user", oldValue, user);
	}

----------------------------------------------------

3º Aplique suas respectivas regras de negocio sobre os dados fornecidos pelo monitor.

	private Boolean hasChanged() {
		return participantRegistry.getPropertyMonitor().hasChanged();
	}





