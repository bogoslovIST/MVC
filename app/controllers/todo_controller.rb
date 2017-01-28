class TodoController < ApplicationController
  before_action :projects_load, only: [:index, :create]

  def index
	@todos = Todo.all
	@project_map = @projects.map{|p| [ p.title, p.id ] }
  end

  def update
  end

  def new
	@todo = Todo.new
  end
  
  def create
	@project = Project.find(params[:todo][:project_id])
	@todo = @project.todos.create(todo_params)
	redirect_to(:back)
  end
  
  private
	def projects_load
		@projects = Project.all
	end
	
    def todo_params
		params.require(:todo).permit(:text)
    end
end
