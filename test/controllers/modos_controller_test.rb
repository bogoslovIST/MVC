require 'test_helper'

class ModosControllerTest < ActionDispatch::IntegrationTest
  setup do
    @modo = modos(:one)
  end

  test "should get index" do
    get modos_url
    assert_response :success
  end

  test "should get new" do
    get new_modo_url
    assert_response :success
  end

  test "should create modo" do
    assert_difference('Modo.count') do
      post modos_url, params: { modo: { todos: @modo.todos } }
    end

    assert_redirected_to modo_url(Modo.last)
  end

  test "should show modo" do
    get modo_url(@modo)
    assert_response :success
  end

  test "should get edit" do
    get edit_modo_url(@modo)
    assert_response :success
  end

  test "should update modo" do
    patch modo_url(@modo), params: { modo: { todos: @modo.todos } }
    assert_redirected_to modo_url(@modo)
  end

  test "should destroy modo" do
    assert_difference('Modo.count', -1) do
      delete modo_url(@modo)
    end

    assert_redirected_to modos_url
  end
end
