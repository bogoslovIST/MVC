Rails.application.routes.draw do
  root 'todo#index'
  
  match '/', to: 'todo#create', via: :post

	resources :projects do
		resources :todos
	end
end
