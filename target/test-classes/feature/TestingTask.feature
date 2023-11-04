@task
Feature: Massmutual testing tesk

  Scenario: verify the havenlife insurence quote results
     Given User launch the havenlife insurence page
     When User verify fourty years of mary quote result with good health
          | Alaska | 04-11-1983 | 500000 |
     Then User verify fifty yeasrs of male gender quote result with fair health
          | California | 04-11-1973 | 500000 |
     And User verify percentage of mary and male gender quote
     Then User verify the quote amounts shown for the state of Montana unique
          | Montana | 04-11-1983 | 500000 |
  