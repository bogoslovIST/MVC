seed_file = Rails.root.join('db', 'seeds', 'seeds.yml')
config = YAML::load_file(seed_file)
hash = (ActiveSupport::HashWithIndifferentAccess.new(config))[:projects]

hash.each do |proj|
	p = Project.create title: proj[:title]
	
	proj[:todos].each do |td|
		p.todos.create text: td[:text], isCompleted: td[:isCompleted]
	end
end