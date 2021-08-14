// Find out all the relationship that exists in the graph
g.V().outE().inV().path().by('code').by('name').by('relation')

// List the details of Tim
g.V().hasLabel('tim').valueMap().unfold()

// List all the outgoing edges from Tim
g.V().hasLabel('tim').outE().inV().path().by('code').by('relation')


// What the Birth year of all the persons and fetch name and corresponding birth year?

// Who is Micheal's manager's manager?
g.V().hasLabel('mike').outE('reports_to').inV().outE('reports_to').inV().path().by('code').by('relation')

// How many managers and associates are there in the graph
g.V().outE('type').inV().hasLabel(within('manager','associate')).groupCount().by(label)

//What are the details of the pet that Micheal has?
g.V().hasLabel('mike').outE('has_pet').inV().valueMap().unfold()


//Find all possible paths between Mike and Alex
g.V().hasLabel('mike').outE().inV().outE().inV().hasLabel('alex').path().by('code').by('relation')

g.V().hasLabel('mike').repeat(out()).until(hasLabel('alex')).path().by('code')


# 4. What is Sam's DOB, gender and whom does she report to?
g.V().hasLabel('sam').as('sam').outE('reports_to').inV().as('manager').select('sam','manager').by(valueMap())

// Find all occurances of people reporting to Alex, either directly or indirectly.
g.V().as('reportee').repeat(out()).until(hasLabel('alex')).as('alex').path().by('code')
