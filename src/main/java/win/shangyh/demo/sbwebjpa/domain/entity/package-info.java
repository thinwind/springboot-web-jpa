@org.hibernate.annotations.GenericGenerator(
  name = "ENTITY_ID_GENERATOR",
  strategy = "enhanced-sequence",
  parameters = {
     @org.hibernate.annotations.Parameter(
        name = "sequence_name",
        value = "ENTITY_SEQUENCE"
     ),
     @org.hibernate.annotations.Parameter(
        name = "initial_value",
        value = "10000"
     )
})
package win.shangyh.demo.sbwebjpa.domain.entity;
