Feature: Consuming an api of GoRest

  Scenario Outline: Registration of a photo consuming an api
    Given Load photo data
      | Title | <Title> |
      | Url   | <Url>   |
    When Create a photo with the post method
    And Consult a photo with the get method
    Then Verify the creation

    Examples:
      | Title                                                  | Url                                          |
      | Panoramica de Medellin y el iconico Metro de la ciudad | https://wallpaperaccess.com/full/2015206.jpg |
