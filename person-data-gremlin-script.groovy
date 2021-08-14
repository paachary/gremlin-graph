conf = new BaseConfiguration()
conf.setProperty("gremlin.tinkergraph.vertexIdManager","LONG")
conf.setProperty("gremlin.tinkergraph.edgeIdManager","LONG")
conf.setProperty("gremlin.tinkergraph.vertexPropertyIdManager","LONG")
graph = TinkerGraph.open(conf)
g=graph.traversal()

person = g.addV('person').property(id, 1).
           property('code', 'Person').
           property('name', 'Person').
           property('desc','This is a type of an entity').
           next()

manager = g.addV('manager').property(id, 2).
            property('code', 'Manager').
            property('name', 'Manager').  
            property('desc','This is a type of an entity').
            next()

animal = g.addV('animal').property(id, 3).
         property('code', 'Animal').
         property('desc','This is a type of an entity').next()

associate = g.addV('associate').
            property(id, 4).property('code', 'Associate').property('desc','This is a type of an entity').next()

alex = g.addV('alex').
            property(id, 5).
            property('code','Alex').
            property('name','Alexender Philip').
            property('born_on','1970-12-01').
            property('gender','Male').
            property('personal_trait','Techie,Foodie,Hard-working').
    next()

            
alex.addEdge('type',person).property('relation','is')
alex.addEdge('type',manager).property('relation','is')
            

tim = g.addV('tim').
            property(id, 6).
            property('code','Tim').
            property('name','Timothy Dalton').
            property('born_on','1963-06-23').
            property('gender','Male').
            property('personal_trait','Techie,Smart,Movie Buff').
    next()
            
tim.addEdge('type',person).property('relation','is')
tim.addEdge('type',manager).property('relation','is')
tim.addEdge('reports_to',alex).property('relation','reports to')

sam = g.addV('sam').
            property(id, 7).
            property('code','Sam').
            property('name','Samantha').
            property('born_on','2002-07-31').
            property('gender','Female').
            property('personal_trait','Techie,Cat-Lover,Hard-working').
    next()
            
sam.addEdge('type',person).property('relation','is')
sam.addEdge('type',associate).property('relation','is')
sam.addEdge('reports_to',tim).property('relation','reports to')

goofy = g.addV('goofy').
            property(id, 8).
            property('code','Goofy_The_Dog').
            property('name','Goofy').
            property('born_on','2019-07-04').next()

goofy.addEdge('type',animal).property('relation','is')
            
mike = g.addV('mike').
            property(id, 9).
            property('code','Mike').
            property('name','Micheal').
            property('born_on','2000-01-01').
            property('gender','Male').
            property('personal_trait','Techie,Smart').
    next()
            
mike.addEdge('type',person).property('relation','is')
mike.addEdge('type',associate).property('relation','is')
mike.addEdge('reports_to',tim).property('relation','reports to')
mike.addEdge('friend_of',sam).property('relation','friend of')
mike.addEdge('has_pet',goofy).property('relation','has pet')



g.io('/home/paachary/rdf-sparql/gremlin/person-data-output.graphml').
    with(IO.writer,IO.graphml).
  write().iterate()
